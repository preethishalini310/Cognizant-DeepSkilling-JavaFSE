import './App.css';
import officeSpaceImg from './officeSpace.svg';
import officeList from './officeList';

function App() {
  // JSX element
  const element = 'Office Space';

  // JSX attribute
  const jsxatt = (
    <img src={officeSpaceImg} width="25%" height="25%" alt="Office Space" />
  );

  return (
    <div className="App">
      <h1>{element} , at Affordable Range</h1>

      {jsxatt}

      {officeList.map((itemName, index) => {
        // Decide the Rent color: red if <= 60000, green if above
        let colors = [];
        if (itemName.Rent <= 60000) {
          colors.push('textRed');
        } else {
          colors.push('textGreen');
        }

        return (
          <div key={index} className="office-card">
            <h1>Name: {itemName.Name}</h1>
            <h3 className={colors.join(' ')}> Rent: Rs. {itemName.Rent}</h3>
            <h3> Address: {itemName.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
