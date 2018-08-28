import React, { Component } from 'react';


export default class OrderInput extends React.Component{

	constructor() {
    super();
    this.state = {
      id: '',
      name: '',
      description: '',
      status: 'new',
    	}
	}
	/*state = {

		name: ''
	}*/

	handleNameChange = event => {
		this.setState({name: event.target.value});
	};

	handleIdChange = event => {
		this.setState({id: event.target.value});
	};

	handleDescriptionChange = event => {
		this.setState({description: event.target.value});
	};

	handleBuyChange = event => {
		this.setState({status: event.target.value});
	};

	handleSubmit = event => {
		event.preventDefault();

		var bid = {
			id: this.state.id,
			name: this.state.name,
			description: this.state.description,
			status: this.state.status
		};
		console.log(bid.name);
		/*axios
			.post('http://localhost:8080/productapi/products', {product})
			.then(res =>{
				console.log(res);
				console.log(res.data);
			});*/

			 fetch('http://localhost:8080/api/orders', {
      			method: 'POST',
      			headers: {
        			'Accept': 'application/json',
       				 'Content-Type': 'application/json'
    			  },
    			  body: JSON.stringify(bid),
    		});

	};


	render() {
		return(

			<form>

     		<input onChange={this.handleNameChange.bind(this)} type="text" name="name" placeholder="Enter order title here" />
     		<input onChange={this.handleDescriptionChange.bind(this)} type="text" name="description" placeholder="Enter Products Requirements" />
     		need to buy: <input onChange={this.handleBuyChange.bind(this)} type="checkbox" name="buy" placeholder="buy" value = "buy" />
     		<button onClick={this.handleSubmit.bind(this)}>Submit</button>

   			</form>

			);


	}


	


}