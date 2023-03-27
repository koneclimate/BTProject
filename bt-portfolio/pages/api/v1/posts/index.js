import axios from "axios";

export default async (req, res)=> {
  try {
    const axiosRes = await axios.get("https://jsonplaceholder.typicode.com/posts");
    const post = axiosRes.data;
    res.status(200).json( post.slice(0, 10) );
  } catch (e) {
    console.error(e);
    res.status(error.status || 400).json({message: 'API Error'});
  }
}

