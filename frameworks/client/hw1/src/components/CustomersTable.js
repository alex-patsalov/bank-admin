import React, {useEffect, useState} from "react";
import Ajax from "../utils/Ajax";
import "./styles.scss";

const CustomersTable = function (){

    const [allCustomers, setCustomers] = useState([]);

    useEffect(()=>{
        async function fetch(){
            const data = await Ajax.get("/customer/all");
            setCustomers(data);
        }
        fetch();
    }, []);

    return(
        <div>
            <table>
                <tbody>{
                allCustomers.map(c =>
                    <tr key={c.id}>
                        <td className="table-data">name: {c.name}</td>
                        <td className="table-data">id: {c.id}</td>
                        <td className="table-data">email: {c.email}</td>
                        <td className="table-data">age: {c.age}</td>
                        {/*<td>accounts: {c.accounts.length === 0 ? "no accounts available" : c.accounts}</td>*/}
                        <td className="table-data">accounts: {c.accounts.length === 0
                            ? "no accounts available"
                            : c.accounts.map(acc =>
                        `[(id:${acc.id}) ${acc.currency}: ${acc.balance}] `)}</td>

                    </tr>
                )
            }</tbody>
            </table>
        </div>
    );
}

export default CustomersTable;