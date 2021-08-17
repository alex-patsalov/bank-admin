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
                        <td className="table-data">id: {c.id}</td>
                        <td className="table-data">name: {c.name}</td>
                        <td className="table-data">email: {c.email}</td>
                        <td className="table-data">age: {c.age}</td>
                        <td className="table-data">phone: {c.phone}</td>
                        <td className="table-data">accounts: {c.accounts.length === 0
                            ? "no accounts available"
                            : c.accounts.map(acc =>
                        `[(id:${acc.id}, number: ${acc.number}) ${acc.currency}: ${acc.balance}] `)}</td>
                        <td className="table-data">employers: {c.employers.length === 0
                            ? "no employers available"
                            : c.employers.map(emp =>
                                `${emp.name} `)}</td>
                    </tr>
                )
            }</tbody>
            </table>
        </div>
    );
}

export default CustomersTable;