function ListofPlayers(props) {
  const { players } = props;

  return (
    <ul>
      {players.map((item, index) => {
        return (
          <li key={index}>
            Mr. {item.name}
            <span> {item.score} </span>
          </li>
        );
      })}
    </ul>
  );
}

export default ListofPlayers;
