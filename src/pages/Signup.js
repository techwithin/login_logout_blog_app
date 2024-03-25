
import Base from "../components/Base";
import { Card, Form, CardBody, CardHeader, Container, Button, FormGroup, Input, Label } from "reactstrap";
import { useState } from "react";
import { signUp } from "../services/user-service";
const Signup = () => {


    const [data, setData] = useState({
        name: '',
        email: '',
        password: '',
        about: '',
    })

    const [error, setError] = useState({
        errors: {},
        isError: false
    })

    const handleChange = (event, property) => {
        // console.log("Name changed");
        setData({ ...data, [property]: event.target.value })
    }

    const resetData = () => {
        setData({
            name: '',
            email: '',
            password: '',
            about: '',
        })
    };

    const submitForm = (event) => {
        console.log(data);
        event.preventDefault();
        signUp(data).then((resp) => {
            console.log(resp)
            console.log("SUCCESS")
        }).catch((error) => {
            console.log(error);
        });
    };


    return (
        <Base>
            <Container>
                {JSON.stringify(data)}
                <Card>
                    <CardHeader>
                        <h3>Fill Information To Register !</h3>
                    </CardHeader>
                    <CardBody>
                        <Form onSubmit={submitForm}>


                            <FormGroup>
                                <Label for="name">Enter Name</Label>
                                <Input type="text" placeholder="Enter Here" invalid="true"
                                    id="name"
                                    onChange={(e) => handleChange(e, 'name')}
                                    value={data.name}

                                />
                            </FormGroup>

                            <FormGroup>
                                <Label for="email">Enter Email</Label>
                                <Input type="email" placeholder="Enter Here" invalid="true"
                                    id="email"
                                    onChange={(e) => handleChange(e, 'email')}
                                    value={data.email}
                                />
                            </FormGroup>

                            <FormGroup>
                                <Label for="password">Enter Password</Label>
                                <Input type="password" placeholder="Enter Here" invalid="true"
                                    id="password"
                                    onChange={(e) => handleChange(e, 'password')}
                                    value={data.password}
                                />
                            </FormGroup>

                            <FormGroup>
                                <Label for="about">Enter About</Label>
                                <Input type="textarea" placeholder="Enter Here"
                                    id="about"
                                    onChange={(e) => handleChange(e, 'about')}
                                    style={{ height: "250px" }}
                                    value={data.about}  // two way binding
                                />
                            </FormGroup>

                            <Container className="text-center">

                                <Button color="dark">Register</Button>
                                <Button onClick={resetData} color="secondary" type="reset" className="ms-2">Reset</Button>

                            </Container>


                        </Form>
                    </CardBody>
                </Card>
            </Container>
        </Base>
    );
};

export default Signup