function ScoreBelow70(props) {
  const { players } = props;
  const players70 = [];

  players.map((item) => {
    if (item.score <= 70) {
      players70.push(item);
    }
    return null;
  });

  return (
    <ul>
      {players70.map((item, index) => {
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

export default ScoreBelow70;
