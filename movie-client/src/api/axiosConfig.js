import axios from 'axios';
// require('dotenv').config();

// const host = process.env.HOST
const host="192.168.15.8"

export default axios.create({
    baseURL: `http://${host}:8080`,
    // headers: {}
})