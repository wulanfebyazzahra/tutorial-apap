import React from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";

export default class App extends React.Component {

  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems });
  };

  // handle list favorit
  handleFavoriteClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems });
  };
  
  state = {
    favItems: [],
    textDisplay: false
  };

  // handle toggle favorite
  clickToggle = () => {
    this.setState(currentState => ({
      textDisplay: !currentState.textDisplay
    }));
  };

  // handle delete favorite
  handleDeleteClick = () => {
    this.setState({favItems: []
    });
  };
  
  render(){
    const { favItems, textDisplay } = this.state;
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>

        <div className="d-flex justify-content-center align-items-center">
          <label className="switch">
            <input 
              type="checkbox" 
              onClick={this.clickToggle} />
              <span className="slider round"></span>
          </label>
          <h4 className="fav-margin col-2">Show Favorites</h4>
        </div>

        <br></br>
        {!favItems.length == 0 ? (
          <div className="d-flex justify-content-center align-items-center">
            <button className="btn btn btn-outline-dark" onClick={this.handleDeleteClick}>
              Delete Favorites
            </button>
          </div>
          ) : (
            null
        )};

        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="ListMovies"
                items={listMovies}
                onItemClick={this.handleItemClick}
              />
            </div>

            <div className={`col-sm ${textDisplay ? "d-block" : "d-none"}`}>
              <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleFavoriteClick}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}