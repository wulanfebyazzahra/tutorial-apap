import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";

const Hotel= (props) => {
    const { id, namaHotel, alamat, nomorTelepon,listKamar, handleEdit, handleDelete } = props;

    return (
        <div className={classes.hotel}>
            <h3>{`ID Hotel ${id}`}</h3>
            <p>{`Nama Hotel: ${namaHotel}`}</p>
            <p>{`Alamat: ${alamat}`}</p>
            <p>{`Nomor Telepon: ${nomorTelepon}`}</p>
            <p>List Kamar: </p>
            <div>
                {listKamar.length === 0 ? <strong>Hotel tidak memiliki kamar</strong>:
                    listKamar.map((value)=>{
                        return (
                            <Button variant="dark" key={`${value.namaKamar}_{value.kapasitasKamar}`}>
                                {value.namaKamar} ({value.kapasitasKamar})
                            </Button>
                        )
                    })
                }
            </div>

            <br/>
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Hotel;