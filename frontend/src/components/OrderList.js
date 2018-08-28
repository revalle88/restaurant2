import React, { Component } from 'react';

class OrderList extends Component {

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
    const response = await fetch('http://localhost:8080/api/orders');
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




  render() {
    const {orders, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
      Order List:
       <table>
           <tr><th>ID</th><th>title</th><th>Product Requirements</th><th>STATUS</th></tr>
               {orders.map(order =>
            <tr>
                <td>{order.id}</td>
                <td>{order.name}</td>
                <td>{order.description}</td>
                <td>{order.status}</td>
                <td> <button size="sm" color="danger" onClick={() => this.remove(order.id)}>Delete</button></td>
            </tr>


             
          )}
       </table>

      </div>
    );
  }
}

export default OrderList;