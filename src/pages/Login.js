import Base from "../components/Base";
import { Card, Form, CardBody, CardHeader, Container, Button, FormGroup, Input, Label } from "reactstrap";


const Login = () => {
    return (
        <Base>
            <Container>

                <Card>
                    <CardHeader>
                        <h3>Fill Information To Login !</h3>
                    </CardHeader>
                    <CardBody>
                        <Form>

                            <FormGroup>
                                <Label for="email">Enter Email</Label>
                                <Input type="email" placeholder="Enter Here" invalid="true"
                                    id="email" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="password">Enter Password</Label>
                                <Input type="password" placeholder="Enter Here" invalid="true"
                                    id="password" />
                            </FormGroup>



                            <Container className="text-center">

                                <Button color="dark">Login</Button>
                                <Button color="secondary" type="reset" className="ms-2">Reset</Button>

                            </Container>


                        </Form>
                    </CardBody>
                </Card>
            </Container>
        </Base>
    );
};

export default Login