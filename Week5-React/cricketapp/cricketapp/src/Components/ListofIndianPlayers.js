function ListofIndianPlayers(props) {
  const { IndianPlayers } = props;

  return (
    <ul>
      {IndianPlayers.map((item, index) => {
        return <li key={index}>Mr. {item}</li>;
      })}
    </ul>
  );
}

export default ListofIndianPlayers;
