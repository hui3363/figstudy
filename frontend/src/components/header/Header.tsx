import styles from './Header.module.scss'
import Nav from './nav/Nav'
import logoImg from '../../assets/logo.png'

const Header = () => {
	return (
		<div className={styles.header}>
			<div className='container'>
				<div className={styles.header_global}>
					<div className={styles.header_logo}>
						<img src={logoImg} alt="무화과 서재" />
					</div>
					<div className={styles.header_global_utils}>
						<button className={styles.util_btn}>회원가입</button>
						<button className={styles.util_btn}>로그인</button>
					</div>
				</div>
				<Nav />
			</div>
		</div>
	)
}

export default Header