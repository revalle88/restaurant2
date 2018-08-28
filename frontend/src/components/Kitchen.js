
import React from 'react';
import OrderInput from './OrderInput';
import OrderList from './OrderList';


const Kitchen = () => (
	<div>
		<h3>Kitchen</h3>
		Enter Order Information:
		 <OrderInput/>

		 <OrderList/>
	</div>
);
export default Kitchen;