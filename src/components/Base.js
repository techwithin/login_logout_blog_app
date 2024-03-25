import App from "../App";
import CustomNavbar from "./CustomNavbar";

const Base = ({ title = "Welcome to our new website", children }) => {
    return (

        <div className="container-fluid">
            <CustomNavbar />

            {children}

        </div>
    );
};

export default Base;