import Ajax from "../utils/Ajax";
import {useState} from "react";

const CreateAccount = () => {

    const [id, setId] = useState(0);
    const [currency, setCurrency] = useState("USD");

    const handleChangeCurrency = (event) => {
        setCurrency(event.target.value);
    }
    const handleChangeId = (event) => {
        setId(event.target.value);
        console.log(event.target.value)
    }

    const createAccount = () => {
        Ajax.post(`customer/accounts/create?id=${id}&currency=${currency}`)
    }

    const deleteCurrency = () => {
        Ajax.delete(`customer/accounts/delete?id=${id}`)
    }

    return (
        <div>
            <div>
                <p>CREATE ACCOUNT</p>
                <form onSubmit={createAccount}>
                    <label htmlFor="userID"> customer ID </label>
                    <input id="userID" name="userID" type="text" onChange={handleChangeId}/>
                    <select onChange={handleChangeCurrency}>
                        <option name="currency" value="USD">USD</option>
                        <option name="currency" value="EUR">EUR</option>
                        <option name="currency" value="UAH">UAH</option>
                        <option name="currency" value="CHF">CHF</option>
                        <option name="currency" value="GBP">GBP</option>
                    </select>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="create"/>
                </form>
            </div>
            <div>
                <p>DELETE ACCOUNT</p>
                <form onSubmit={deleteCurrency}>
                    <label htmlFor="accountID"> account ID </label>
                    <input id="accountID" name="accountID" type="text" onChange={handleChangeId}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="delete"/>
                </form>
            </div>
        </div>
    );

}
export default CreateAccount;