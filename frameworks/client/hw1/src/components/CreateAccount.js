import Ajax from "../utils/Ajax";
import {useState} from "react";

const CreateAccount = () => {

    const [id, setId] = useState(0);
    const [currency, setCurrency] = useState("");

    const handleChangeCurrency = (event) => {
        setCurrency(event.target.value);
    }
    const handleChangeId = (event) => {
        setId(event.target.value);
    }

    const submitForm = () => {
        Ajax.post(`customer/accounts/create?id=${id}&currency=${currency}`)
    }

    return (
        <div>
            <p>CREATE ACCOUNT</p>
            <form onSubmit={submitForm}>
                <label htmlFor="userID"> customer ID </label>
                <input id="userID" name="id" type="text" onChange={handleChangeId}/>
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
    );

}
export default CreateAccount;