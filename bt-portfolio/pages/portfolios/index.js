import BaseLayout from "@/components/layouts/BaseLayout";
import Link from "next/link";
import BasePage from "@/components/BasePage";
import { useGetPost } from "@/actions";


const Portfolio = () => {
  
  const { data, error,loading } = useGetPost();

  const renderPosts = () => {
    return data.map((post) => (
      <li key={post.id}>
        <Link href={`/portfolios/${post.id}`}>{post.title}</Link>
      </li>
    ));
  };

  return (
    <BaseLayout>
      <BasePage>
        <h1>I am Portfolio Page</h1>
        {loading && <p>loading data.....</p>}
        {data && <ul>{renderPosts()}</ul>}
        {error && <div className="alert alert-danger">{error.message}</div>}
      </BasePage>
    </BaseLayout>
  );
};

export default Portfolio;
