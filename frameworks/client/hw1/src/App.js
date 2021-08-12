import CustomersTable from "./components/CustomersTable";
import FormToCreate from "./components/FormToCreate"

const App = function () {
    return (
        <div className="App">
            <h1>These are all available customers</h1>
            <CustomersTable/>
            <FormToCreate/>
        </div>
    );
}

export default App;
