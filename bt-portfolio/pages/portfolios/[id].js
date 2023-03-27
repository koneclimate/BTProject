import { useGetPostById } from "@/actions";
import BasePage from "@/components/BasePage";
import BaseLayout from "@/components/layouts/BaseLayout";
import { useRouter } from "next/router";

const Portfolio = () => {
  const router = useRouter();
  const {
    data: Portfolio,
    error,
    loading,
  } = useGetPostById(router.query.id);

  return (
    <BaseLayout>
      <BasePage>
        {loading && <p>Loading Data...</p>}
        {error && <div className="alert alert-danger">{error.message}</div>}
        {Portfolio && (
          <>
            <h1>I am Portfolio Page</h1>
            <h1>{Portfolio.title}</h1>
            <p>BODY: {Portfolio.body}</p>
            <p>ID: {Portfolio.id}</p>
          </>
        )}
      </BasePage>
    </BaseLayout>
  );
};

export default Portfolio;
