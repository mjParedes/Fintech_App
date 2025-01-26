import Slider from "react-slick";

export const CarrouselRecommends = () => {

  const settings = {
    dots: true, 
    infinite: true, 
    speed: 500, 
    slidesToShow: 3, 
    slidesToScroll: 1,
    responsive: [
      {
        breakpoint: 1024, 
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  };

  return (
    <div className="max-w-7xl mx-auto py-8">
      <Slider {...settings}>
        {/* Slide 1 */}
        <div className="bg-blue-500 p-6 rounded-lg">
          <h3 className="text-white text-2xl">Recomendación 1</h3>
          <p className="text-white mt-4">Aquí va la descripción de la recomendación 1.</p>
        </div>

        {/* Slide 2 */}
        <div className="bg-red-500 p-6 rounded-lg">
          <h3 className="text-white text-2xl">Recomendación 2</h3>
          <p className="text-white mt-4">Aquí va la descripción de la recomendación 2.</p>
        </div>

        {/* Slide 3 */}
        <div className="bg-green-500 p-6 rounded-lg">
          <h3 className="text-white text-2xl">Recomendación 3</h3>
          <p className="text-white mt-4">Aquí va la descripción de la recomendación 3.</p>
        </div>

        {/* Slide 4 */}
        <div className="bg-yellow-500 p-6 rounded-lg">
          <h3 className="text-white text-2xl">Recomendación 4</h3>
          <p className="text-white mt-4">Aquí va la descripción de la recomendación 4.</p>
        </div>

        {/* Slide 5 */}
        <div className="bg-purple-500 p-6 rounded-lg">
          <h3 className="text-white text-2xl">Recomendación 5</h3>
          <p className="text-white mt-4">Aquí va la descripción de la recomendación 5.</p>
        </div>
      </Slider>
    </div>
  );
};
