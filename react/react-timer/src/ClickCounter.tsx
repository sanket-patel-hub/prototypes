import { useState } from "react"
import { Button, Container } from "react-bootstrap";
import { ChevronLeft } from "react-bootstrap-icons";

export const ClickCounter = (props:{initial:number}) => {

    const [click, countClick] = useState(props.initial);

    return(
        <Container fluid="md" className="pt-5">
           <p>
               <a href="/" title="back to home"><ChevronLeft/> Home</a>
           </p>
            <span className="mr-3">{click}</span>
            <Button variant="primary" onClick={()=> countClick(prevclick => prevclick+1)} >Click</Button>
        </Container>
    );
}