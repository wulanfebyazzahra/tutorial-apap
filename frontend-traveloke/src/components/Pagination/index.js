import React from 'react';
import classes from "./styles.module.css";

const Pagination = ({totalPage, interval, currentPage, handleClick}) =>{
    const count = Math.ceil(totalPage/interval) || 1

    return(
        <div style={{textAlign: "center"}}>
            {[...Array(count)].map((_x,i)=>(
                <span
                key={i}
                onClick={() => handleClick(i)}
                style={{fontWeight: currentPage === i && 800}}
                className={classes.number}
                >{i+1}
                </span>
            ))}
        </div>
    );
};

export default Pagination;