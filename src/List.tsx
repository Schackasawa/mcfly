
const List = ({ data }) => {
  return (
    <ul>
      {data.map(item => (
        <li key={item.cca2}>{item.name.common}</li>
      ))}
    </ul>
  );
};

export default List;
