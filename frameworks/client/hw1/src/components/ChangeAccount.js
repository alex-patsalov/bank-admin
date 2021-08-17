import Ajax from "../utils/Ajax";
import {useState} from "react";

const ChangeAccount = () => {

    const [account, setAccount] = useState({
        accountNumber: '', sum: 0
    })

    const handleChange = (event) => {
        setAccount({...account, [event.target.name]: event.target.value});
    }

    const submitForm = (data) => {
        // data.preventDefault();
        Ajax.put(`/account/put?accountNumber=${account.accountNumber}&sum=${account.sum}`)
    }

    return (
        <div style={{display: "inline-block", marginLeft: '20px'}}>
            <p>PUT MONEY</p>
            <form onSubmit={submitForm}>
                <label htmlFor="accountNumber"> account number </label>
                <input id="accountNumber" name="accountNumber" type="text" onChange={handleChange}/>
                <label htmlFor="sum"> amount </label>
                <input id="sum" name="sum" type="text" onChange={handleChange}/>
                <input style={{margin: '0 0 0 20px'}} type="submit" value="PUT"/>
            </form>
        </div>
    );

}
export default ChangeAccount;