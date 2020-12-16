import React, { Component } from "react";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Hotel from "../../components/Hotel";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import SearchFilter from "../../components/SearchFilter";
import Pagination from "../../components/Pagination";

class HotelList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            hotels: [],
            searchedHotels: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isFilter: false,
            namaHotel: "",
            alamat: "",
            nomorTelepon: "",
            page:0,
        };
        this.handleAddHotel = this.handleAddHotel.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
        this.handleEditHotel = this.handleEditHotel.bind(this);
        this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
        this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
        this.searchFilter = this.searchFilter.bind(this);
        this.handlePage= this.handlePage.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData(){
        this.setState({isLoading: true});
        try{
            const fetchedHotels = [];
            const response = await APIConfig.get("/hotels");
            for(let key in response.data){
                fetchedHotels.push({
                    ...response.data[key]
                });
            }
            this.setState({
                hotels: fetchedHotels,
                searchedHotels: fetchedHotels.slice(0, 5),                
            })
        }catch(error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.setState({isLoading: false});
    }
    

    // Handle Add
    handleAddHotel() {
        this.setState({ isCreate: true });
    }

    async handleSubmitAddHotel(event) {
        event.preventDefault();
        try {
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.post("/hotel", data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);

        // Mengosongkan form
        this.setState({
            namaHotel: "",
            alamat: "",
            nomorTelepon: "",
        })
    }

    // Handle Cancel
    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    // Handle Change
    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    // Handle Edit
    handleEditHotel(hotel) {
        this.setState({
            isEdit: true,
            id: hotel.id,
            namaHotel: hotel.namaHotel,
            alamat: hotel.alamat,
            nomorTelepon: hotel.nomorTelepon,
        });
    }

    // Submit Edit
    async handleSubmitEditHotel(event) {
        event.preventDefault();
        try {
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.put(`/hotel/${this.state.id}`, data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    // Handle Delete
    async handleDeleteHotel(id) {
        try {
            await APIConfig.delete(`/hotel/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    // Handle Loading
    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    // Search Filter
    searchFilter (text) {
        if (text === "") {
            this.setState({ searchedHotels: this.state.hotels});
            this.setState( {isFilter: false} );
        } else {
            const filteredHotels = this.state.hotels.filter(hotel => {
                return hotel.namaHotel.toLowerCase().indexOf(text.toLowerCase()) === 0;
            });

            this.setState({ searchedHotels: filteredHotels });
            this.setState( {isFilter: true} );
        }
    };

    // Pagination
    handlePage(page){
        this.setState({page});
    }

    render() {
        return (
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <Button onClick={this.handleAddHotel} variant="primary">
                    Add Hotel
                </Button>
                
                <SearchFilter onChange={this.searchFilter}></SearchFilter>

                {this.state.isLoading == true ? <h5 className={classes.title}>Fetching Data...</h5> : null}

                {this.state.isFilter ?
                    (
                        <div>
                            {this.state.searchedHotels && this.state.searchedHotels.map((hotel) => (
                                <Hotel
                                    key={hotel.id}
                                    id={hotel.id}
                                    namaHotel={hotel.namaHotel}
                                    alamat={hotel.alamat}
                                    nomorTelepon={hotel.nomorTelepon}
                                    listKamar = {hotel.listKamar}
                                    handleEdit={() => this.handleEditHotel(hotel)}
                                    handleDelete={() => this.handleDeleteHotel(hotel.id)}
                                />
                            ))}
                        </div>
                    ):(
                        <div>
                            {this.state.hotels.slice(this.state.page*5, (this.state.page+1)*5).map((hotel) => (
                                <Hotel
                                    key={hotel.id}
                                    id={hotel.id}
                                    namaHotel={hotel.namaHotel}
                                    alamat={hotel.alamat}
                                    nomorTelepon={hotel.nomorTelepon}
                                    listKamar = {hotel.listKamar}
                                    handleEdit={() => this.handleEditHotel(hotel)}
                                    handleDelete={() => this.handleDeleteHotel(hotel.id)}
                                />
                            ))}
                        </div>
                    )
                }

                <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                    <form>
                        <h3 className={classes.modalTitle}>
                            {this.state.isCreate
                                ? "Add Hotel"
                                : `Edit Hotel Nomor ${this.state.id}`}
                        </h3>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Hotel"
                            name="namaHotel"
                            value={this.state.namaHotel}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Alamat"
                            name="alamat"
                            value={this.state.alamat}
                            onChange={this.handleChangeField}
                        />
                        <textarea
                            className={classes.textField}
                            placeholder="Nomor Telepon"
                            name="nomorTelepon"
                            rows="4"
                            value={this.state.nomorTelepon}
                            onChange={this.handleChangeField}
                        />
                        <Button
                            onClick={
                                this.state.isCreate
                                    ? this.handleSubmitAddHotel : this.handleSubmitEditHotel
                            }
                            variant="primary"
                        >
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>

                        <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                        </Button>
                    </form>
                </Modal>

                <Pagination 
                interval={5}
                currentPage={this.state.page}
                totalPage={this.state.hotels.length}
                handleClick={this.handlePage}
                />
            </div>
        );
    }
}
export default HotelList;