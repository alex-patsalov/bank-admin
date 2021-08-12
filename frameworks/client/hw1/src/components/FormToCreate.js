import Ajax from "../utils/Ajax";

const FormToCreate = () => {

    const submitForm = (data) => {
        const {name, email, age} = data;
        let customer = {age: age, email: email, name: name};
        Ajax.post("/customer/create", customer)
    }

    return (
        <div>
            <p>CREATE A CUSTOMER</p>
            <form method="post" action="http://localhost:9000/customer/create" onSubmit={submitForm}>
                <label htmlFor="name"> name </label>
                <input id="name" name="name" type="text"/>
                <label htmlFor="email"> email </label>
                <input id="email" name="email" type="text"/>
                <label htmlFor="age"> age </label>
                <input id="age" name="age" type="text"/>
                <input style={{margin: '0 0 0 20px'}} type="submit" value="create"/>
            </form>
        </div>
    );

}
export default FormToCreate;