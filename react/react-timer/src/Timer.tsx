import React, { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import { ChevronLeft } from "react-bootstrap-icons"
import date from 'date-and-time'
export const Timer = () => {
    const [second, setSecond] = useState(new Date());

    useEffect(()=> {
        setTimeout(() => setSecond(date.addSeconds(second,1)),1000);
    },[second])

    return (
        <Container fluid="md" className="pt-5">
           <p>
                <a href="/" title="back to home"><ChevronLeft/> Home</a>
           </p>
            {date.format(second,'MMM D YYYY HH:mm:ss')}
        </Container>
    )
}