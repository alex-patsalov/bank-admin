import Ajax from "../utils/Ajax";
import {useState} from "react";

const ChangeAccount = () => {

    const [account, setAccount] = useState({
        accountNumber: '', balance: 0
    })

    const handleChange = (event) => {
        setAccount({...account, [event.target.name]: event.target.value});
    }

    const submitForm = () => {
        // data.preventDefault();
        Ajax.put(`/account/put?accountNumber=${account.accountNumber}`, account)
    }

    const withdrawMoney = () => {
        // data.preventDefault();
        Ajax.put(`/account/withdraw?accountNumber=${account.accountNumber}`, account)
    }

    return (
        <div>
            <div style={{display: "inline-block"}}>
                <p>PUT MONEY</p>
                <form onSubmit={submitForm}>
                    <label htmlFor="accountNumber"> account number </label>
                    <input id="accountNumber" name="accountNumber" type="text" onChange={handleChange}/>
                    <label htmlFor="balance"> amount </label>
                    <input id="balance" name="balance" type="text" onChange={handleChange}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="PUT"/>
                </form>
            </div>
            <div style={{display: "inline-block", marginLeft: '20px'}}>
                <p>WITHDRAW MONEY</p>
                <form onSubmit={withdrawMoney}>
                    <label htmlFor="accountNumber"> account number </label>
                    <input id="accountNumber" name="accountNumber" type="text" onChange={handleChange}/>
                    <label htmlFor="balance"> amount </label>
                    <input id="balance" name="balance" type="text" onChange={handleChange}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="WITHDRAW"/>
                </form>
            </div>
        </div>
    );

}
export default ChangeAccount;