import React from 'react'
import { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'
import api from '../../api/axiosConfig'
import { Container, Row, Col } from 'react-bootstrap'
import Reviewform from '../reviewform/Reviewform'

const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {
    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;

    useEffect(() => {
        getMovieData(movieId);
    }, [])

    const addReview = async (e) => {
        e.preventDefault();
        const rev = revText.current;
        try{
            const response = await api.post("/api/v1/reviews", 
            {reviewBody:rev.value, imdbId:movieId});
            const updateReviews = [...reviews, {body:rev.value}];
            rev.value = "";
            setReviews(updateReviews);
        } catch(err){
            Console.error(err);
        }
        
    }

    return (
        <Container style={{color: 'white'}}>
            <Row>
                <Col><h3>Reviews</h3></Col>
            </Row>
            <Row>
                <Col>
                    <img src={movie?.poster} alt="" />
                </Col>
                <Col>
                    {
                        <>
                            <Row>
                                <Col>
                                    <Reviewform 
                                        handleSubmit={addReview}
                                        revText={revText}
                                        labelText="Write a Review?"
                                    />
                                </Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr />
                                </Col>
                            </Row>
                        </>
                    }
                    {
                        reviews?.map((r) => {
                            return (
                                <>
                                    <Row>
                                        <Col>{r.body}</Col>
                                        <Row>
                                            <Col>
                                                <hr />
                                            </Col>
                                        </Row>
                                    </Row>
                                </>
                            )
                        })
                    }
                </Col>
            </Row>
        </Container>
    )
}

export default Reviews