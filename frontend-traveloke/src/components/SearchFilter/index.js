import React, { Component } from "react";
import classes from "./styles.module.css";

export default class SearchFilter extends Component {
  handleChange = e => {
    this.props.onChange(e.target.value);
  };

  render() {
    const { query } = this.props;
    
    return (
      <React.Fragment>
        <div className="container h-100">
          <div className="d-flex justify-content-center h-100">
            <input
              className={classes.searchinput}
              placeholder="Cari hotel..."
              name="search"
              type="text"
              value={query}
              onChange={this.handleChange}
            />
          </div>
        </div>
      </React.Fragment>
    );
  }
}