import Ajax from "../utils/Ajax";
import {useState} from "react";

const ModifyCustomer = () => {

    const [user, setUser] = useState({
        id: 1, age: '', email: '', name: 'name', phone: '', password: ''
    })

    const handleChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    }

    const submitForm = (data) => {
        // data.preventDefault();
        Ajax.put(`/customer?id=${user.id}`, user)
    }

    return (
        <div>
            <p>MODIFY A CUSTOMER</p>
            <form onSubmit={submitForm}>
                <label htmlFor="id"> id </label>
                <input id="id" name="id" type="text" onChange={handleChange}/>
                <label htmlFor="name"> name </label>
                <input id="name" name="name" type="text" onChange={handleChange}/>
                <label htmlFor="email"> email </label>
                <input id="email" name="email" type="text" onChange={handleChange}/>
                <label htmlFor="age"> age </label>
                <input id="age" name="age" type="text" onChange={handleChange}/>
                <label htmlFor="phone"> phone </label>
                <input id="phone" name="phone" type="text" onChange={handleChange}/>
                <label htmlFor="password"> password </label>
                <input id="password" name="password" type="text" onChange={handleChange}/>
                <input style={{margin: '0 0 0 20px'}} type="submit" value="MODIFY"/>
            </form>
        </div>
    );

}
export default ModifyCustomer;