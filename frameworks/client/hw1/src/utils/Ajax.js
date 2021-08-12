import axios from "axios";

const env = "http://localhost:9000";

class Ajax {

    static async get(endpoint) {
        const {data} = await axios.get(`${env}${endpoint}`)
        // console.log('get all data-->', data);
        return data
    }
}

export default Ajax;