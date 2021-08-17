import CustomersTable from "./components/CustomersTable";
import CreateCustomer from "./components/CreateCustomer"
import CreateAccount from "./components/CreateAccount";
import DeleteCustomer from "./components/DeleteCustomer";
import ModifyCustomer from "./components/ModifyCustomer";
import ChangeAccount from "./components/ChangeAccount";
import TransferMoney from "./components/TransferMoney";

const App = function () {
    return (
        <div className="App">
            <h1>These are all available customers</h1>
            <CustomersTable/>
            <CreateCustomer/>
            <ModifyCustomer/>
            <DeleteCustomer/>
            <CreateAccount/>
            <ChangeAccount/>
            <TransferMoney/>
        </div>
    );
}

export default App;
