import axios from 'axios';
import { Platform } from 'react-native';

const api = axios.create({
    baseURL: 'http://192.168.0.114:3333',
});

export default api;
