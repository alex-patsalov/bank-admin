import CustomersTable from "./components/CustomersTable";
import FormToCreate from "./components/FormToCreate"
import CreateAccount from "./components/CreateAccount";

const App = function () {
    return (
        <div className="App">
            <h1>These are all available customers</h1>
            <CustomersTable/>
            <FormToCreate/>
            <CreateAccount/>
        </div>
    );
}

export default App;
