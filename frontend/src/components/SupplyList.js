import React, { Component } from 'react';

class SupplyList extends Component {

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
    const response = await fetch('http://localhost:8080/api/buyorders');
    const body = await response.json();
    this.setState({ orders: body, isLoading: false });
  }



async completeOrder(id){

var details = {
    
};

var formBody = [];
formBody.push("id="+id)

    await fetch('http://localhost:8080/api/orders/buy', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
  },
  body: formBody
}).then(this.refreshList)


}


  render() {
    const {orders, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (

    <div>
        Orders to buy:
        <table>
            <tr><th>ID</th><th>title</th><th>Product Requirements</th><th>STATUS</th></tr>
            {orders.map(order =>
                <tr>
                    <td>{order.id}</td>
                    <td>{order.name}</td>
                    <td>{order.description}</td>
                    <td>{order.status}</td>
                    <td> <button size="sm" color="danger" onClick={() => this.completeOrder(order.id)}>Buy</button></td>
                </tr>



            )}
        </table>

    </div>


    );
  }
}

export default SupplyList;