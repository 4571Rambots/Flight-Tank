package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
    private final TalonSRX m_leftFrontMotor = new TalonSRX(7);
    private final TalonSRX m_leftRearMotor = new TalonSRX(6);
    private final TalonSRX m_rightFrontMotor = new TalonSRX(12);
    private final TalonSRX m_rightRearMotor = new TalonSRX(10);
    private final Joystick m_leftJoystick = new Joystick(0);
    private final Joystick m_rightJoystick = new Joystick(1);

    @Override
    public void robotInit() {
        m_leftFrontMotor.setInverted(false);
        m_leftRearMotor.setInverted(false);
        m_rightFrontMotor.setInverted(true);
        m_rightRearMotor.setInverted(true);
    }

    @Override
    public void teleopPeriodic() {
        // Get the y-axis values from both joysticks
        double leftSpeed = -m_leftJoystick.getY();
        double rightSpeed = -m_rightJoystick.getY();

        // Set the speed of the motors
        m_leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
        m_leftRearMotor.follow(m_leftFrontMotor);

        m_rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
        m_rightRearMotor.follow(m_rightFrontMotor);
    }
}
