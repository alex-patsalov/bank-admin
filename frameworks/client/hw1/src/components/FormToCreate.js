import Ajax from "../utils/Ajax";
import {useState} from "react";

const FormToCreate = () => {

    const [user, setUser] = useState({
        age: '', email: '', name: 'name'
    })

    const handleChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value});
    }

    const submitForm = (data) => {
        // data.preventDefault();
        Ajax.post("/customer/create", user)
    }

    return (
        <div>
            <p>CREATE A CUSTOMER</p>
            <form onSubmit={submitForm}>
                <label htmlFor="name"> name </label>
                <input id="name" name="name" type="text" onChange={handleChange}/>
                <label htmlFor="email"> email </label>
                <input id="email" name="email" type="text" onChange={handleChange}/>
                <label htmlFor="age"> age </label>
                <input id="age" name="age" type="text" onChange={handleChange}/>
                <input style={{margin: '0 0 0 20px'}} type="submit" value="create"/>
            </form>
        </div>
    );

}
export default FormToCreate;