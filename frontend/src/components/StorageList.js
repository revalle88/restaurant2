import React, { Component } from 'react';


class StorageList extends Component {

   constructor(props) {
        super(props);
        this.refreshList = this.refreshList.bind(this);
    }

  state = {
    isLoading: true,
    orders: []
  };

  async componentDidMount() {
    this.refreshList();
  }

 async refreshList() {
    const response = await fetch('http://localhost:8080/api/storeorders');
    const body = await response.json();
    this.setState({ orders: body, isLoading: false });
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


async completeOrder(id){

var details = {
    
};

var formBody = [];
formBody.push("id="+id)


fetch('http://localhost:8080/api/orders/send', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
  },
  body: formBody
})




}




  render() {
    const {orders, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
      
       
               {orders.map(order =>
            <div key={order.id}>
             {order.id}
              {order.name}
              <button size="sm" color="danger" onClick={() => this.completeOrder(order.id)}>Send to Kitchen</button>
            </div>
             
          )}
       
      </div>
    );
  }
}

export default StorageList;