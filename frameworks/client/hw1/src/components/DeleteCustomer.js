import Ajax from "../utils/Ajax";
import {useState} from "react";

const DeleteCustomer = () => {

    const [id, setId] = useState(1)

    const handleChange = (event) => {
        setId( event.target.value);
    }

    const submitForm = (data) => {
        // data.preventDefault();
        Ajax.delete(`/customer/delete?id=${id}`)
    }

    return (
        <div>
            <p>DELETE A CUSTOMER</p>
            <form onSubmit={submitForm}>
                <label htmlFor="id"> id </label>
                <input id="id" name="id" type="text" onChange={handleChange}/>
                <input style={{margin: '0 0 0 20px'}} type="submit" value="DELETE"/>
            </form>
        </div>
    );

}
export default DeleteCustomer;