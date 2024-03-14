import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

// const http = axios.create({
//   baseURL: "http://localhost:8080"
// })

// export default {
//   list() {
//     return http.get('/scores');
//   }
// }

const getScores = async () => {
    try {
      const response = await axios.get(`${BASE_URL}/scores`);
  
      const scores = response.data;
  
      console.log(`GET: Here's the list of scores`, scores);
  
      return scores;
    } catch (errors) {
      console.error(errors);
    }
  };

  const main = async () => {
    await getScores ();
  };
  
  main();