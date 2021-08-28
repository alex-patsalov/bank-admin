import Ajax from "../utils/Ajax";
import {useState} from "react";

const CreateEmployer = () => {

    const [employer, setEmployer] = useState({
        name: '', address: ''
    })
    const [idDelete, setIdDelete] = useState(0);
    const [empCus, setEmpCus] = useState({empId: 0, cusId: 0});

    const assignEmployer = (event) => {
        setEmpCus({...empCus, [event.target.name]: event.target.value});
    }

    const handleChange = (event) => {
        setEmployer({...employer, [event.target.name]: event.target.value});
    }

    const handleIdDelete = (event) => {
        setIdDelete(event.target.value);
    }

    const createEmployer = () => {
        Ajax.post(`/employer`, employer)
    }

    const assignEmployerToCustomer = () => {
        Ajax.post(`/customer/setEmployer?cID=${empCus.cusId}&eID=${empCus.empId}`, )
    }

    const deleteEmployer = () => {
        Ajax.delete(`/employer?id=${idDelete}`)
    }

    return (
        <div>
            <div style={{display: "inline-block"}}>
                <p>CREATE EMPLOYER</p>
                <form onSubmit={createEmployer}>
                    <label htmlFor="empName"> employer name </label>
                    <input id="empName" name="name" type="text" onChange={handleChange}/>
                    <label htmlFor="empAdd"> employer address </label>
                    <input id="empAdd" name="address" type="text" onChange={handleChange}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="CREATE"/>
                </form>
            </div>
            <div style={{display: "inline-block", marginLeft: '20px'}}>
                <p>DELETE EMPLOYER</p>
                <form onSubmit={deleteEmployer}>
                    <label htmlFor="empId"> employer ID </label>
                    <input id="empId" name="empId" type="text" onChange={handleIdDelete}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="DELETE"/>
                </form>
            </div>
            <div style={{display: "inline-block", marginLeft: '20px'}}>
                <p>ASSIGN EMPLOYER</p>
                <form onSubmit={assignEmployerToCustomer}>
                    <label htmlFor="cusId"> customer ID </label>
                    <input id="cusId" name="cusId" type="text" onChange={assignEmployer}/>
                    <label htmlFor="empId"> employer ID </label>
                    <input id="empId" name="empId" type="text" onChange={assignEmployer}/>
                    <input style={{margin: '0 0 0 20px'}} type="submit" value="ASSIGN"/>
                </form>
            </div>
        </div>
    );

}
export default CreateEmployer;