def convert_temp(temp_val, unit):
    if unit == 'celsius':
        return (temp_val * 9 / 5) + 32
    else:
        return (temp_val - 32) * 5 / 9


while True:
    temperature = float(input("Enter the temperature value you want to convert "))
    user_unit = input("convert from fahrenheit or celsius (enter F for fahrenheit or C for "
                      "celsius)? ")
    if user_unit == 'F':
        print('celsius temperature {}'.format(convert_temp(temperature, 'fahrenheit')))
    else:
        print('fahrenheit temperature {}'.format(convert_temp(temperature, 'celsius')))
