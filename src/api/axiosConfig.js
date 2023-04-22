import axios from 'axios';

function getFirstNonLocalhostIPv4() {
    const nets = Object.values(networkInterfaces());
    let ipv4 = '';
  
    for (const net of nets) {
      const familyV4Value = net.family === 'IPv4' ? 'IPv4' : 4;
      if (net.family === familyV4Value && !net.internal && net.address !== '127.0.0.1') {
        ipv4 = net.address;
        break;
      }
    }
  
    return ipv4;
  }
  
const host_local_ip = getFirstNonLocalhostIPv4()

export default axios.create({
    baseURL: `http://${host_local_ip}:8080`
})