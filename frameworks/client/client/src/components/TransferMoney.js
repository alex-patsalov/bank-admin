import Ajax from "../utils/Ajax";
import {useState} from "react";

const ChangeAccount = () => {

    const [account, setAccount] = useState({
        from: '', to: '', sum: 0
    })

    const handleChange = (event) => {
        setAccount({...account, [event.target.name]: event.target.value});
    }

    const withdrawMoney = () => {
        // data.preventDefault();
        Ajax.put(`/account/transfer?from=${account.from}&to=${account.to}&sum=${account.sum}`)
    }

    return (
        <div>
            <div style={{borderWidth: '5px', borderBottom: 'solid black'}}>
                <p>TRANSFER MONEY</p>
                <form onSubmit={withdrawMoney}>
                    <label htmlFor="accountNumber"> account number (FROM) </label>
                    <input id="accountNumber" name="from" type="text" onChange={handleChange}/>
                    <label htmlFor="accountNumber"> account number (TO) </label>
                    <input id="accountNumber" name="to" type="text" onChange={handleChange}/>
                    <label htmlFor="sum"> amount </label>
                    <input id="sum" name="sum" type="text" onChange={handleChange}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="SEND"/>
                </form>
            </div>
        </div>
    );

}
export default ChangeAccount;