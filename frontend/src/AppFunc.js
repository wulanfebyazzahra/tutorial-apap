import React, { useState } from "react";

import List from "./components/List";
import listMovies from "./movies.json";
import "./App.css";

import styled, { css } from "styled-components";
import "./styles.css";
/**
* Building React component using functional programming paradigm
*/
function App() {
// Btw, this is hooks. useState function returns an array
// contains the state and a function to set the state -> [state, setState].
// What you see below is array destruction.
// Let say you have an array const arr = ["aaa", "bbb"], to access the item
// we can use index arr[0] OR destruct it like below
// const [varName, index1] = arr, variable varName is guaranteed to get the value of index
//0 OR "aaa"
// here is the illustration for this situation
// below is the return value of useState
// [favItems, setFavItems] = [state, setState]

// Demo dark mode
// Source: https://yamagata-developers-society.github.io/blog/build-darkmode-switch/

    const fetchLSItem = itemName => window.localStorage.getItem(itemName);
    const setLSItem = (itemName, value) =>
    window.localStorage.setItem(itemName, value);

    const AppWrapper = styled.div`
    padding: 16px;
    transition: background-color 0.3s ease-in-out;

    ${({ darkmode }) =>
        darkmode
        ? css`
            background-color: var(--color-darkmode-layer-1);
            color: var(--color-white);
            `
        : ""}
    `;

    const initDarkmodeSetting = fetchLSItem("darkmode") === "true";
    const [darkmode, setDarkmode] = useState(initDarkmodeSetting);
    const pageTitle = darkmode ? "Light Mode" : "Dark Mode";

    const handleToggleDarkmode = () => {
        const newDarkmodeValue = !darkmode;
    
        setDarkmode(newDarkmodeValue);
        setLSItem("darkmode", newDarkmodeValue);
      };

    const [favItems, setFavItems] = useState(() => []);

    function handleItemClick(item) {
        // immutability
        const newItems = [...favItems];
        const newItem = { ...item };
        // Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if (targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1); // delete 1 item at index targetInd
        // trigger to set a new state
        setFavItems(newItems);
    }

return (
    <div className="container-fluid">
        <AppWrapper darkmode={darkmode}>
            <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
            (This is a <strong>function-based</strong> application)
            </p>

            <div className="d-flex justify-content-center align-items-center">
                <label className="switch">
                    <input
                    type="checkbox"
                    onChange={handleToggleDarkmode}
                    checked={darkmode}
                    />
                    <span className="slider round" />
                </label>
                <p>{pageTitle}</p>
            </div>

                <div className="container pt-3">
                    <div className="row">
                        <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={handleItemClick}
                        />
                        </div>

                        <div className="col-sm">
                            <List
                                title="My Favorites"
                                items={favItems}
                                onItemClick={handleItemClick}
                            />
                        </div>
                    </div>
                </div>
        </AppWrapper>
    </div>
    );
   }

   export default App;