import React, { useState } from "react";
import ReactDOM from "react-dom";

import { Card, ListGroup, Button } from "react-bootstrap";
import { XLg } from "react-bootstrap-icons";

import "bootstrap/dist/css/bootstrap.min.css";

let todos = [
  {
    id: 0,
    name: "take a bath",
    description: "use water and soap to clean your body everyday."
  },
  {
    id: 1,
    name: "make a breakfast",
    description: "follow recipe from book for breakfast"
  },
  {
    id: 2,
    name: "get ready to go office",
    description: "be ready on time to reach office"
  }
];

let App = () => {
  return <ToDoList />;
};

let ToDo = (props) => {
  return (
    <ListGroup.Item>
      <div className="row">
        <div className="col-10">
          <h5>{props.activity.name}</h5>
          <p>{props.activity.description}</p>
        </div>
        <div className="col-2">
          <Button
            variant="primary"
            size="sm"
            onClick={() => {
              props.deleteToDo(props.activity.id);
            }}
          >
            <XLg />
          </Button>
        </div>
      </div>
    </ListGroup.Item>
  );
};

let ToDoList = () => {
  let [activities, setActivities] = useState(todos);

  let deleteToDo = (id) => {
    setActivities(
      activities.filter((activity) => activity.id !== +JSON.stringify(id))
    );
  };

  const todoList = activities.map((activity) => (
    <ToDo key={activity.id} activity={activity} deleteToDo={deleteToDo} />
  ));

  return (
    <Card style={{ width: "90%" }}>
      <ListGroup variant="flush">{todoList}</ListGroup>
    </Card>
  );
};
ReactDOM.render(<App />, document.getElementById("container"));
