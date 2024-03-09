const BASE_URL = "http://localhost:8080";

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