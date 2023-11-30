import axios from "axios"; 

export default axios.create({
    baseURL: 'http://localhost:8080/', 
    headers: {"ngrok-skip-drowser-warining": "true"}
});