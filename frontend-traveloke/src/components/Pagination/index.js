import React from 'react';
import classes from "./styles.module.css";

const Pagination = ({interval, currentPage, totalPage, handleClick}) =>{

    // Untuk membagi total page dengan interval (untuk mengetahui berapa page)
    const page = Math.ceil(totalPage/interval) || 1

    return(
        <div style={{textAlign: "center"}}>
            {[...Array(page)].map((_x,i)=>(
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