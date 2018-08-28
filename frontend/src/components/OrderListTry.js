import React, { Component } from 'react';

class OrderList extends Component {

   constructor(props) {
        super(props);
        this.refreshList = this.refreshList.bind(this);
    }

  state = {
    isLoading: true,
    products: []
  };

  async componentDidMount() {
    this.refreshList();
  }

 async refreshList() {
    const response = await fetch('http://localhost:8080/api/orders');
    const body = await response.json();
    this.setState({ products: body, isLoading: false });
  }


async remove(id) {
    await fetch('http://localhost:8080/api/orders/'+id, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(this.refreshList)
  }




  render() {
    const {products, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
      
       
          {products.map(product =>
            <div key={product.id}>
             {product.id}
              {product.name}
              <button size="sm" color="danger" onClick={() => this.remove(product.id)}>Delete</button>
            </div>
             
          )}
       
      </div>
    );
  }
}

export default OrderList;