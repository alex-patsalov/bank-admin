import axios from "axios";

class Ajax {

    static async get(endpoint) {
        const {data} = await axios.get(`${endpoint}`)
        console.log('get all data-->', data);
        return data
    }

    static async post(endpoint, object) {
        const {data} = await axios.post(endpoint, object ,
            {
            headers: {
                'Content-Type': 'application/json',
            }
        }
        )
        console.log('post new data-->', data);
        return data;
    }

    static async put(endpoint, id, updatedObject) {
        const {data} = await axios.put(endpoint,id, updatedObject, {
            headers: {
                'Content-Type': 'application/json',
            }
        })
        console.log('update old data-->', data);
        return data;
    }

    static async delete(endpoint, id) {
        // const {data} = await axios.delete(`${endpoint}/${id}`, {
        const {data} = await axios.delete(endpoint, id)
        console.log('delete data-->', data);
        return data;
    }
}

export default Ajax;